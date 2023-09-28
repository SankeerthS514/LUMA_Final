import axios from 'axios';
import React, {useState} from 'react'
import { Card } from 'react-bootstrap';
import { useLocation, useNavigate } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function LoanApply(props) {
    const url = "http://localhost:8080/api/v5/loan";
    const navigate = useNavigate();
    const location = useLocation();
const userId = location.state && location.state.userId;

    const initialUserId = props.userId;
    const [id,setId] = useState(initialUserId);
    const [val,setVal] = useState('');
    const [duration, setDuration] = useState('');
    const [category, setCategory] = useState('');
    const [itemDescription, setItemDescription] = useState('');
    const [itemMadeOf, setItemMadeOf] = useState('');
    const [itemMadeOfOptions, setItemMadeOfOptions] = useState([]);
    const [dat, setDat] = useState('');

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
    console.log(userId);
    //console.log(secondname);
    axios.post(url,{empid:userId,item_cat:category,item_make:itemMadeOf,
    item_desc:itemDescription,duration_in_years:duration,item_value:val,issue_date:dat, status:"Pending"})
    .then(response => {
      console.log(response);
      if(response.data == 'sucess'){
        toast.success(`Your loan for ${category} has been added to queue and is waiting for admin approval!`)
        navigate(`/view-loan/${userId}`, {state: {userId: userId}});}
    })
    .catch(error=>{console.log(error)});
    console.log("sent");
    setTimeout(() => {
      navigate(`/view-loan/${userId}`);
    }, 3000);
}

    return (
        
        <div>
            <center>
                <Card>
                    <Card.Title><h1>Loan Management Application</h1></Card.Title>
                    <Card.Body>
                        <h3>Select Product and apply for Loan for {`${userId}`}</h3>
                        <form style={{"padding-left":"35%","padding-right":"35%", "padding-top":"2%"}}>
                            <div style={{"border":"1px solid black", "padding":"5% 5% 5%"}}>
                            <div className="form-outline mb-4 form-group">
                <input
                  type="text"
                  id="employee_id"
                  className="form-control"
                  onChange={(e) => setId(e.target.value)}
                  placeholder="Enter User-Id"
                  value={userId}
                  disabled
                  required
                />
              </div> 
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
                                    <input type="number" id="duration" 
                                    onChange={(e)=>setDuration(e.target.value)} class="form-control" 
                                    placeholder="Duration in Years" required/>
                                </div>
                                <button type="button" class="btn btn-dark btn-block mb-4" 
                                onClick={handleSubmit} >Apply Here</button>
                            </div>
                        </form>
                    </Card.Body>
                </Card>
            </center>
            <ToastContainer
position="top-center"
autoClose={3000}
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
    )
}

export default LoanApply;