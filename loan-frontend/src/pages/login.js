import PropTypes from 'prop-types'
import React, {useState, Component} from 'react'
import { useNavigate, route, withRouter } from 'react-router-dom'
import axios from "axios";
import { Card } from 'react-bootstrap';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Login=()=>{

const url = "http://localhost:8080/api/v3/login"
const [username, setUsername] = useState('');
const [pass, setPass] = useState('');
const [error, setError] = useState('');
const navigate = useNavigate();

const handleSubmit = () => {
    console.log(username);
    console.log(pass);
    if(!username)
      setError('FailUser');
    else if(!pass)
      setError('FailPass');
    else{
      axios.post(url,{id:username,password:pass})
    .then(response => {
      console.log(response);
      if(response.data == 'sucess'){
        if(username==69 && pass=="avad1234")
        {
          navigate("/admin", {state: {userId: username}})
        }
        else
          navigate("/home", {state: {userId: username}});
      }
      else
        setError(response.data);
    })
    .catch(error=>{console.log(error)});
    console.log("sent");
    }
}
    return (
        <div>
            <center>
              <div style={{"padding-top":"100px"}}>
                <h1>Loan Management Application</h1>
                <br/>
              </div>
            
            <form style={{"padding-left":"35%","padding-right":"35%", "padding-top":"2%"}}>
                <div style={{"border":"1px solid black", "padding":"5% 5% 5%"}}>
                <h3>User Login</h3>
                <br/>
                <div class="form-outline mb-4 form-group">
                  <input id="form2Example1" class="form-control" placeholder="Enter User-ID"
                  onChange={(e)=>setUsername(e.target.value)} type="number" required/>
                  {error == 'FailUser' && (
                    <div style={{"color":"red"}}>
                      User does not exist!
                    </div>
                  )}
                </div>
                
                <div class="form-outline mb-4 form-group">
                <input type="password" id="form2Example2" class="form-control" placeholder="Enter Password" 
                onChange={(e)=>setPass(e.target.value)} required/>
                {error == 'FailPass' && (
                  <div style={{"color":"red"}}>
                    Wrong Password!!!
                  </div>
                )}
                </div>
                <button type="button" class="btn btn-dark btn-block mb-4" onClick={handleSubmit}>Login</button>
                <div class="text-center">
                  <p>Not a member? <a href="/user-register">Register</a></p>
                </div></div>
            </form>
            </center>
        </div>
    )
}

export default Login