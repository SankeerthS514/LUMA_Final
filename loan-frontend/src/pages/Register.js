import React, {useState} from "react";
import { Card } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import axios from 'axios'
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function Register(){
    const navigate = useNavigate();
    const navigateLogin=()=>{navigate("/login");}
    const url = "http://localhost:8080/api/v1/employees"
    const [username, setUsername] = useState('');
    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [desig, setDesig] = useState('');
    const [department, setDepartment] = useState('');
    const [mail, setMail] = useState('');
    const [dob, setDob] = useState('');
    const [doj, setDoj] = useState('');
    const [error,setError] = useState({});
    var newError = {};

    const validate = () => {
        var isValid = true;
        //first name check
        if(!firstname){
            newError.firstnameError = "First name is required!";
            isValid = false;
        }
        else if(firstname.length < 3){
            newError.firstnameError = "First name must be atleast 3 characters long";
            isValid = false;
        }
        //last name check
        if(!lastname){
            newError.lastnameError = "Last name is required!";
            isValid = false;
        }
        //email check
        if(!mail){
            newError.emailError = "Email is required!";
            isValid = false;
        }
        else if(!mail.toString().includes("@")){
            newError.emailError = "Invalid email!";
            isValid = false;
        }
        //dob check
        if(!dob){
            newError.dobError = "Date of birth is required!";
            isValid = false;
        }
        //designation check
        if(!desig){
            newError.designationError = "Designation is required!";
            isValid = false;
        }
        //dept check
        if(!department){
            newError.deptError = "Department is required!";
            isValid = false;
        }
        //doj check
        if(!doj){
            newError.dojError = "Date of joining is required!";
            isValid = false;
        }
        return isValid;
    }

    const handleSubmit = () => {
        setError(newError);
        // console.log(firstname);
        // console.log(lastname);
        //validate
        console.log(validate());
        // console.log(firstname);
        // console.log(lastname);
        // if(firstname==="" || lastname==="" || desig==="" || department==="" || mail==="" || dob==="" || doj==="")
        // {
        //     alert("Please Fill All Fields");
        // }
        // else{
        // axios.post(url,{firstName:firstname,lastName:lastname,id:username,designation:desig,
        // deparment:department,emailId:mail,dob:dob,doj:doj})
        // .then(response => {
        //   console.log(response);
        //   if(response.data == 'sucess')
        //     navigate("/admin");
        // })
        // .catch(error=>{console.log(error)});
        // console.log("sent");
        // alert("Data Submitted");}
        if(validate()){
            axios.post(url,{firstName:firstname,lastName:lastname,id: username,designation:desig,
            deparment:department,emailId:mail,dob:dob,doj:doj})
            .then(response => {
                console.log(response);
                if(response.data == 'sucess')
                    navigate("/admin");
            })
            .catch(error=>{console.log(error)});
            console.log("sent");
            // toast("Data Submitted");
            toast(`User '${username}' created`);
            // alert("Toast");
            const timer = setTimeout(() => {
                navigate("/admin");
              }, 3000);
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
                     {<div class="form-outline mb-4 form-group">
                        <input type="text" id="uid" class="form-control" 
                        onChange={(e)=>setUsername(e.target.value)}
                        placeholder="Enter User-ID" required/>
                    </div>} 
                    <div class="form-outline mb-4 form-group">
                        <input type="email" id="mail" class="form-control" 
                        onChange={(e)=>setMail(e.target.value)}
                        placeholder="Enter Email ID" required/>
                        {error.emailError && (
                            <div style={{"color":"red"}}>
                                {error.emailError}
                            </div>
                        )}
                    </div>
                    {/* <div class="form-outline mb-4 form-group">
                        <input type="password" name="password" id="password" 
                         class="form-control" placeholder="Enter Password" required/>
                    </div>
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="confirm_password" class="form-control" 
                        placeholder="Repeat Password" name="confirm_password" required/>
                    </div> */}
                    <div className="form-outline mb-4 form-group">
  <input
    type="date"
    id="dob"
    className="form-control"
    onChange={(e) => setDob(e.target.value)}
    placeholder="Enter Date of Birth"
    required
  />
  {error.dobError && (
    <div style={{ color: 'red' }}>{error.dobError}</div>
  )}
</div>

                    
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="desig" class="form-control" 
                        onChange={(e)=>setDesig(e.target.value)}
                        placeholder="Enter Designation" required/>
                        {error.designationError && (
                            <div style={{"color":"red"}}>
                                {error.designationError}
                            </div>
                        )}
                    </div>
                    <div class="form-outline mb-4 form-group">
                        <input type="text" id="dept" class="form-control" 
                        onChange={(e)=>setDepartment(e.target.value)}
                        placeholder="Enter Department" required/>
                        {error.deptError && (
                            <div style={{"color":"red"}}>
                                {error.deptError}
                            </div>
                        )}
                    </div>
                    <div class="form-outline mb-4 form-group">
                        <input type="date" id="jod" class="form-control" 
                        onChange={(e)=>setDoj(e.target.value)}
                        placeholder="Enter Date of Joining(YYYY/MM/DD)" onfocus="(this.type='date')" required/>
                        {error.dojError && (
                            <div style={{"color":"red"}}>
                                {error.dojError}
                            </div>
                        )}
                    </div>
                    <button type="button" class="btn btn-dark btn-block mb-4" onClick={handleSubmit} >Submit</button>
                    </div>
                    <div></div>
                </form>
            </Card>
            <br/>
        <br/>
        </center>
        
    </div>
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
    </>
    )
}

export default Register;