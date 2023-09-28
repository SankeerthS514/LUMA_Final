import React, {useState} from "react";
import { Card } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function UserRegistar(){
    const navigate = useNavigate();
    const navigateLogin=()=>{navigate("/login");}
    const url = "http://localhost:8080/api/v3/user"
    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [uid,setUid] = useState('');
    const [pass, setPass] = useState('');
    const [error,setError] = useState({});
    var newError = {};

    const validate = () =>{
        var isValid = true;
        if(!firstname){
            newError.firstnameError = "First name is required!";
            isValid = false;
        }
        if(!lastname){
            newError.lastnameError = "Last Name is required!";
            isValid = false;
        }
        if(!pass || (pass.length < 8)){
            newError.passError = "Invalid Password. Create a stronger password!"
            isValid = false;
        }
        return isValid;
    }

    const handleSubmit = () => {
        // console.log(firstname);
        // console.log(lastname);
        setError(newError);
        // if(firstname==="" || lastname==="" || uid=="" || pass=="")
        // {
        //     alert("Please Fill All Fields");
        // }
        if(validate()){
        axios.post(url,{firstName:firstname,lastName:lastname,id:uid,
        password:pass})
        .then(response => {
          console.log(response);
            if(response.status == 200){
                toast.success(`User: ${uid} succesfully registered!`);
                navigate("/login");
            }
            else{
                toast(`Employee already registered as user or ${uid} does not exist!`);
            }
        })
        .catch(error=>{
            console.log(error);
            toast.error(error.response.data.message);
            console.log("Error");
        });
        // console.log("sent");
        // navigate("/login");
        // alert("Data Submitted");
        }
    }

        
    return(
    <>
    <div>
        <center>
            <Card>
                <Card.Title><h1>User Registration Form</h1></Card.Title><br/><br/>
                <form style={{"padding-left":"35%","padding-right":"35%", "padding-top":"2%"}}>
                    <div style={{"border":"1px solid black", "padding":"5% 5% 5%"}}>
                    <h3>User Registration</h3>
                    <br/>
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="fname" class="form-control"
                        onChange={(e)=>setFirstName(e.target.value)}
                         placeholder="Enter First Name" required/>
                         {error.firstnameError && (
                            <div style={{"color":"red"}}>
                                {error.firstnameError}
                            </div>
                        )}
                    </div> 
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="lname" class="form-control" 
                        onChange={(e)=>setLastName(e.target.value)}
                        placeholder="Enter Last Name" required/>
                        {error.lastnameError && (
                            <div style={{"color":"red"}}>
                                {error.lastnameError}
                            </div>
                        )}
                    </div>
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="uid" class="form-control" 
                        onChange={(e)=>setUid(e.target.value)}
                        placeholder="Enter User-ID" required/>
                    </div>
                    <div class="form-outline mb-4 form-group">
                        <input type="password" name="password" id="password" onChange={(e)=>setPass(e.target.value)}
                         class="form-control" placeholder="Enter Password" required/>
                         {error.passError && (
                            <div style={{"color":"red"}}>
                                {error.passError}
                            </div>
                        )}
                    </div>
                    
                    <button type="button" class="btn btn-dark btn-block mb-4" onClick={handleSubmit} >Submit</button>
                    <div class="text-center">
                    <p>Already a member? <a href="/login">Login</a></p>
                    </div></div>
                </form>
            </Card>
            <br/>
        <br/>
        </center>
        
    </div>
    <ToastContainer
position="top-center"
autoClose={2000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
/>
    </>
    )
}

export default UserRegistar;