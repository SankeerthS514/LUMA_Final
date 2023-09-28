// Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const MainHome = () => {
  return (
    
    <div className="container-fluid dark-bg">
      <center>
      <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Loan Management System</h1></div><br/>
                    <p>A Loan Management application for user and admin workings.<br/>
                    Apply for loans and view loan status as user also the purchase history. <br/>
                    Admin can grant lone, view all employee and manage loans</p><br/><br/>
        </div>
      <div className="row justify-content-center align-items-center h-100">
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Login</h5>
              <p className="card-text">Click to log in.</p>
              <Link to="/login" className="btn btn-primary">
                Go to Login
              </Link>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Register</h5>
              <p className="card-text">Click to register.</p>
              <Link to="/user-register" className="btn btn-primary">
                Go to Register
              </Link>
            </div>
          </div>
        </div>
      </div></center>
    </div>
  );
};

export default MainHome;
