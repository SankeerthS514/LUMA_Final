import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Container, Nav, NavDropdown, Navbar } from 'react-bootstrap';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AdminDashboard = ()=>{
    const navigate = useNavigate();
    const navigatetoEmployee=()=>{
        navigate('/admin/list');
    }
    const navigateViewCat=()=>{
        navigate("/admin/viewcat");
    }
    const navigateEmployeeloan=()=>{
        navigate('/admin/loanlist');
    }
    const navigateUserRegistration=()=>{
        navigate('/register');
    }
    const navigateLoanCard=()=>{
        navigate('/admin/loancard');
    }
        return (
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Admin Dashboard</h1></div>
                    <div><p>Only for Admin Usage</p></div>
                    <br/>
                    
                </div>
                <br/>
                <div className='container'>
                    <div className='card-deck mb-3 text-center row'>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>Employee Details</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>View all Employees</li>
                                    <li>Edit Employee Details</li>
                                    <li>Delete Employee</li>
                                    
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                 onClick={navigatetoEmployee}>View Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>Employee Loan Details</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>View all the employees' loans</li>
                                    <li>Employee specific transactions</li>
                                    <li>Approve, Delete and Close loans</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark" onClick={navigateEmployeeloan}
                               >View Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>Employee Registration</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>Register the employees</li>
                                    <li>Assign the employee id</li>
                                    <li>Employee Specific</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                onClick={navigateUserRegistration}
                               >Add Here</button>
                            </div>
                        </div></div>
                        </div>
                        <div className='card-deck mb-3 text-center row'>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>View/Add Items</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>View the available items</li>
                                    <li>Add new items</li>
                                    <li>Admin only</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                onClick={navigateViewCat}
                               >View Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>View Loan Cards</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>View all the loan cards</li>
                                    <li>Admin viewable</li>
                                    <li>Loan status</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                onClick={navigateLoanCard}
                               >View Here</button>
                            </div>
                        </div></div>
                    </div>
                </div>
            </center>
        </div>
    )
}

export default AdminDashboard;