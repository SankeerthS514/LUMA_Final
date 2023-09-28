import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Navbar = () => {
  const location = useLocation();
  const userId = location.state && location.state.userId;

  return (
    <div>
      <nav className={`navbar navbar-expand-lg bg-dark fixed-top navbar-dark`}>
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            Loan Management Application
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            
          </div>
          <div class=" my-2 my-lg-0">
          <ul className="navbar-nav ml-auto">
              {userId && (
                <li className="nav-item">
                  <span className="nav-link" style={{"color":"white"}}>
                    Welcome, (ID: {userId})
                  </span>
                </li>
              )}
              {(location.pathname !=="/login" && location.pathname!=="/" && 
              location.pathname !=="/user-register") && 
               <li className='nav-item ml-auto'>
               <Link to="/login" className='btn btn-outline-light'>
                 LogOut
               </Link>
             </li>
            }
            </ul>
    </div>
        </div>
        
      </nav>
    </div>
  );
};

export default Navbar;