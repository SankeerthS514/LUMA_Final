import React, { useEffect, useState } from 'react'
// import LoanCard from './LoanCard';
// import LoanApply from './LoanApply';
// import PurchasedItems from './PurchasedItems';
import { useLocation, useNavigate } from 'react-router-dom';
import { Container, Nav, NavDropdown, Navbar } from 'react-bootstrap';
import axios from 'axios';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const UserHome = (props)=>{

    const navigate = useNavigate();
    const location = useLocation();
    const [employee, setEmployee] = useState([]);
    const userId = location.state && location.state.userId;
    const getById=async (userId)=>{
        const response=await axios.get(`http://localhost:8080/api/v1/employees/${userId}`)
        return response.data;
    }
    useEffect(() => {
        return async () => {
        const response = await getById(userId);
        setEmployee(response);
        console.log("This is from useEffect", response);
        console.log(response);
        };
    }, []);
    const navigateLoanCard=()=>{
        navigate(`/loan-card/${userId}`);
    }
    const navigateViewLoan=()=>{
        navigate(`/view-loan/${userId}`);
    }
    const navigateLoanApply=()=>{
        navigate('/loan-apply', {state: {userId: userId}});
    }
    const navigatePurchasedItems=()=>{
        navigate(`/issued-items/${userId}`);
    }
        return (
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    
                    <h3>User Dashboard for {employee.firstName} {employee.lastName}</h3>
                </div>
                <br/>
                <div className='container'>
                    <div className='card-deck mb-3 text-center row'>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>Apply for Loans</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>Fill a form</li>
                                    <li>Apply for loan</li>
                                    <li>Enjoy your benefits</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                 onClick={navigateLoanApply}>Apply Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>View all Loans</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>See all the </li>
                                    <li>Applied loans</li>
                                    <li style={{"font-color":"red"}}>User Specific</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                onClick={navigateViewLoan}
                               >View Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>View Items Purchased</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>See all the </li>
                                    <li>Purchased Items</li>
                                    <li style={{"font-color":"red"}}>User Specific</li>
                                </ul>
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark"
                                onClick={navigatePurchasedItems}>View Here</button>
                            </div>
                        </div></div>
                        <div className='col' style={{"padding":"2%"}}>
                        <div className='card mb-4 box-shadow'>
                            <div className='card-header'>
                                <h4 className='font-bold'>Loan Cards</h4>
                            </div>
                            <div className='card-body'>
                                <ul className='list-unstyled mt-3 mb-4'>
                                    <li>See all the </li>
                                    <li>Approved loans</li>
                                    <li style={{"font-color":"red"}}>User Specific</li>
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

export default UserHome;