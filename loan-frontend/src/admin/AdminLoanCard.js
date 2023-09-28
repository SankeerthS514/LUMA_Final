import React from 'react';
import { useEffect, useState } from "react";
import axios from 'axios';
import { useParams } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function AdminLoanCard(){
    const [employees, setEmployees] = useState([]);
    const params=useParams();
    const getAll = async () => {
        const response = await axios.get(`http://localhost:8080/api/v2/loan`);
        console.log("This is from get All", response.data);
        return response.data;
      };

    useEffect(() => {
        return async () => {
        const response = await getAll();
        setEmployees(response);
        console.log("This is from useEffect", response);
        };
    }, []);
    return(
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Loan Cards</h1></div><br/>
                    <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th><center>Loan-Id</center></th>
            <th><center>Loan Type</center></th>
            <th><center>Duration in Years</center></th>
            <th><center>Status</center></th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
                <td><center>{employee.id}</center></td>
              <td><center>{employee.loan_type}</center></td>
              
              <td><center>{employee.duration_in_years}</center></td>
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

export default AdminLoanCard;