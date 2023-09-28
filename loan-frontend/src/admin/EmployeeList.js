import React from 'react';
import { useEffect, useState } from "react";
import { getAll } from './api';
import { Link, useNavigate } from 'react-router-dom';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function EmployeeList(){
    const navigate = useNavigate();
    const [employees, setEmployees] = useState([]);
    function formatDate(dateString) {
      if(!dateString)
          return "";
      const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
      const date = new Date(dateString);
      return date.toLocaleDateString('en-GB', options);
    }
    useEffect(() => {
        return async () => {
        const response = await getAll();
        setEmployees(response);
        console.log("This is from useEffect", response);
        };
    }, []);
    const handleDelete=(id)=>{
        navigate(`/admin/delete/${id}`);
    }
    const navigateUpdate=(id)=>{
        navigate(`/admin/update/${id}`);
    }
    return(
        <div>
            <center>
                <div className='container' style={{"padding-top":"7%"}}>
                    <div><h1>Admin Dashboard</h1></div><br/>
                    <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th><center>Employee Id</center></th>
            <th><center>First Name</center></th>
            <th><center>Last Name</center></th>
            <th><center>Designation</center></th>
            <th><center>Department</center></th>
            <th><center>Email</center></th>
            <th><center>Date of Birth</center></th>
            <th><center>Date of Joining</center></th>
            <th><center>Actions</center></th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
                <td><center>{employee.id}</center></td>
              <td><center>{employee.firstName}</center></td>
              <td><center>{employee.lastName}</center></td>
              <td><center>{employee.designation}</center></td>
              <td><center>{employee.deparment}</center></td>
              <td><center>{employee.emailId}</center></td>
              <td><center>{formatDate(employee.dob)}</center></td>
              <td><center>{formatDate(employee.doj)}</center></td>
              <td>
  <div style={{ display: 'flex', gap: '10px' }}>
    <Link to={`../admin/update/${employee.id}`} className="btn btn-outline-warning">
      Update
    </Link>
    <button
      style={{
        padding: '10px',
        border: '2px solid red', // Red outline
      }}
      className='btn btn-outline-danger'
      onClick={() => handleDelete(employee.id)}
    >
      Delete
    </button>
  </div>
</td>

              
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

export default EmployeeList;