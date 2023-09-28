import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

import Navbar from './layout/Navbar';
import Login from './pages/login';
import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom';
import Register from './pages/Register';
import UserHome from './pages/Userhome';
import LoanApply from './pages/LoanApply';
import AdminDashboard from './admin/AdminDasboard';
import Loanlist from './admin/LoanList'
import UserRegistar from './user/UserRegistar';
import EmployeeList from './admin/EmployeeList';
import DeleteEmployee from './admin/DeleteEmployee';
import EditEmployee from './admin/EditEmployee';
import UserLoan from './pages/UserLoan';
import AddCategory from './admin/AddCategory';
import PurchasedItems from './pages/PurchasedItems';
import LoanCard from './pages/LoanCard';
import AdminLoanCard from './admin/AdminLoanCard';
import ViewCategory from './admin/ViewCategory';
import { useEffect, useState } from 'react';
import SplashScreen from './pages/SplashScreen';
import MainHome from './pages/MainHome';
function App() {
  // const [redirect, setRedirect] = useState(false);
  // //const navigate = useNavigate();
  // useEffect(() => {
  //   // Simulate a delay to mimic loading your main application
  //   setTimeout(() => {
  //     setRedirect(true); // Set the redirect flag to true after 3 seconds
  //   }, 3000); // Change the delay as needed
  // }, []);

  return (
    <div className="App">
      <BrowserRouter>
      <Navbar/>
      {/* {redirect ? (
        navigate("/login")
      ) : (
        <SplashScreen setRedirect={setRedirect} />
      )} */}
      <Routes>
        <Route exact path='/' element={<MainHome/>}/>
        <Route exact path='/home' element={<UserHome/>}/>
        <Route exact path='/user-register' element={<UserRegistar/>}/>
        <Route exact path='/admin'element={<AdminDashboard/>}/>
        <Route exact path='/admin/list' element={<EmployeeList/>}/>
        <Route exact path='/admin/loanlist' element={<Loanlist/>}/>
        <Route exact path='/admin/addcat' element={<AddCategory/>}/>
        <Route exact path='/admin/delete/:id' element={<DeleteEmployee/>}/>
        <Route exact path='/admin/update/:id' element={<EditEmployee/>}/>
        <Route exact path="/login" element={<Login/>}/>
        <Route exact path="/register" element={<Register/>}/>
        <Route exact path='/loan-apply' element={<LoanApply/>}/>
        <Route exact path='/loan-card/:empid' element={<LoanCard/>}/>
        <Route exact path='/view-loan/:empid' element={<UserLoan/>}/>
        <Route exact path='/issued-items/:empid' element={<PurchasedItems/>}/>
        <Route exact path='/admin/loancard' element={<AdminLoanCard/>}/>
        <Route exact path='/admin/viewcat' element={<ViewCategory/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
