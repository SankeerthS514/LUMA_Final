import axios from 'axios';
import React, { useState } from 'react'
import { Card } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AddCategory =()=>{
    const [category, setCategory] = useState('');
    const [itemDescription, setItemDescription] = useState('');
    const [itemMadeOf, setItemMadeOf] = useState('');
    const [val, setVal] = useState('');
    const [itemMadeOfOptions, setItemMadeOfOptions] = useState([]);
    const url = "http://localhost:8080/api/v6/item";
    const navigate = useNavigate();

    const handleCategoryChange = (event) => {
        const selectedCategory = event.target.value;
        setCategory(selectedCategory);
        setItemDescription('');
        setItemMadeOf('');
        setItemMadeOfOptions([]);
      };
    
      const handleItemDescriptionChange = (event) => {
        const selectedDescription = event.target.value;
        setItemDescription(selectedDescription);
    
        // Set item made of options based on the selected category and description
        if (category === 'Furniture') {
          if (selectedDescription === 'Chair') {
            setItemMadeOfOptions(['Steel', 'Wooden']);
          } else if (selectedDescription === 'Table') {
            setItemMadeOfOptions(['Steel', 'Wooden']);
          }
        } else if (category === 'Electronics') {
          if (selectedDescription === 'Phone') {
            setItemMadeOfOptions(['Apple', 'Samsung']);
          } else if (selectedDescription === 'Headphone') {
            setItemMadeOfOptions(['Boat', 'Noise']);
          } else if (selectedDescription === 'Keyboard') {
            setItemMadeOfOptions(['Asus', 'Apple']);
          }
        } else {
          setItemMadeOfOptions([]); // Reset item made of options if no category or description is selected
        }
      };
    
      const handleItemMadeOfChange = (event) => {
        setItemMadeOf(event.target.value);
      };
    
      const handleSubmit = () => {
        //console.log(secondname);
        axios.post(url,{itemcat:category,itemmake:itemMadeOf,
        itemdesc:itemDescription,itemvalue:val,status:"Available"})
        .then(response => {
          console.log(response);
          if(response.data == 'sucess')
            navigate("/admin/viewcat");
        })
        .catch(error=>{console.log(error)});
        console.log("sent");
        toast(`${itemDescription} has been added to the inventory`);
        const timer = setTimeout(() => {
          navigate("/admin/viewcat");
        }, 1000);
    }
    return(
    <div>
            <center>
                <Card>
                    <Card.Title><h1>Add an Category</h1></Card.Title>
                    <Card.Body>
                        
                        <form style={{"padding-left":"35%","padding-right":"35%", "padding-top":"2%"}}>
                            <div style={{"border":"1px solid black", "padding":"5% 5% 5%"}}>
                            <div class="form-outline mb-4 form-group">
                                    <select value={category} onChange={handleCategoryChange} 
                                    class="form-control">
                                        <option value="">Select Category</option>
                                        <option value="Furniture">Furniture</option>
                                        <option value="Electronics">Electronics</option>
                                    </select>
                                    <div class="mb-4"></div>
                                    {category && (
                                        <div class="form-outline mb-4 form-group">
                                        
                                        <select value={itemDescription} class="form-control" onChange={handleItemDescriptionChange}>
                                            <option value="">Select Item Description</option>
                                            {category === 'Furniture' ? (
                                            <>
                                                <option value="Chair">Chair</option>
                                                <option value="Table">Table</option>
                                            </>
                                            ) : category === 'Electronics' ? (
                                            <>
                                                <option value="Phone">Phone</option>
                                                <option value="Headphone">Headphone</option>
                                                <option value="Keyboard">Keyboard</option>
                                            </>
                                            ) : null}
                                        </select>
                                        </div>
                                    )}

                                    {itemDescription && (
                                        <div class="form-outline mb-4 form-group">
                                        
                                        <select value={itemMadeOf} class="form-control" onChange={handleItemMadeOfChange}>
                                            <option value="">Select Item Made Of</option>
                                            {itemMadeOfOptions.map((item, index) => (
                                            <option key={index} value={item}>
                                                {item}
                                            </option>
                                            ))}
                                        </select>
                                        </div>
                                    )}
                                </div>
                                <div class="form-outline mb-4 form-group">
                                    <input type="number" id="item_val"
                                    onChange={(e)=>setVal(e.target.value)} class="form-control" 
                                    placeholder="Item Value" required/>
                                </div>
                                <button type="button" class="btn btn-dark btn-block mb-4" 
                                onClick={handleSubmit} >Add Here</button>
                            </div>
                        </form>
                    </Card.Body>
                </Card>
            </center>
            <ToastContainer
position="top-center"
autoClose={1000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
/>
        </div>
)}

export default AddCategory;