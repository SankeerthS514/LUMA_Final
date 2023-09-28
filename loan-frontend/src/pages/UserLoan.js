import React from 'react';
import { useEffect, useState } from "react";
import axios from 'axios';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useParams } from 'react-router-dom';

function UserLoan(){
    const [employees, setEmployees] = useState([]);
    const params=useParams();
    const getAll = async (empid) => {
        const response = await axios.get(`http://localhost:8080/api/v5/loan/${empid}`);
        console.log("This is from get All", response.data);
        return response.data;
      };
      function formatDate(dateString) {
        if(!dateString)
          return "";
        const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
        const date = new Date(dateString);
        return date.toLocaleDateString('en-GB', options);
      }
    useEffect(() => {
        return async () => {
        const response = await getAll(params.empid);
        setEmployees(response);
        console.log("This is from useEffect", response);
        };
    }, []);
    return(
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Loan Details</h1></div><br/>
                    <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th><center>Loan-Id</center></th>
            <th><center>Employee-Id</center></th>
            <th><center>Item Catagory</center></th>
            <th><center>Item Description</center></th>
            <th><center>Item Made of</center></th>
            <th><center>Duration in years</center></th>
            <th><center>Value</center></th>
            <th><center>Issue Date</center></th>
            <th><center>Status</center></th>
            
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.empid}>
                <td><center>{employee.id}</center></td>
              <td><center>{employee.empid}</center></td>
              
              <td><center>{employee.item_cat}</center></td>
              <td><center>{employee.item_make}</center></td>
              <td><center>{employee.item_desc}</center></td>
              <td><center>{employee.duration_in_years}</center></td>
              <td><center>{employee.item_value}</center></td>
              <td><center>{formatDate(employee.issue_date)}</center></td>
              <td><center>{employee.status}</center></td>
              
            </tr>
          ))}
        </tbody>
      </table>

                </div>
                <br/>


            </center>
        </div>
    )
}

export default UserLoan;