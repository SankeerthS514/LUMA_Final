import React from 'react'
// import LoanCard from './LoanCard';
// import LoanApply from './LoanApply';
// import PurchasedItems from './PurchasedItems';
import { useLocation, useNavigate } from 'react-router-dom';
import { Container, Nav, NavDropdown, Navbar } from 'react-bootstrap';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Home = (props)=>{
    const navigate = useNavigate();
    const location = useLocation();
    const userId = location.state && location.state.userId;
    const navigateLoanCard=()=>{
        navigate(`/loan-card/${userId}`);
    }
    const navigateLoanApply=()=>{
        navigate('/loan-apply', {state: {userId: props.userId}});
    }
    // const navigatePurchasedItems=()=>{
    //     navigate('/purchased-items');
    // }
        return (
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Loan Management Application</h1></div>
                    <div><p>An application to apply for loans with user dashboard and Admin access</p></div>
                    <br/>
                    <h3>User Dashboard</h3>
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
                                onClick={navigateLoanCard}
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
                                <button type="button" class="btn btn-lg btn-block btn-outline-dark">View Here</button>
                            </div>
                        </div></div>
                    </div>
                </div>
            </center>
        </div>
    )
}

export default Home;