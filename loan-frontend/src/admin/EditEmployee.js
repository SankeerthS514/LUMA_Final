import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {addEmployee, getById, updateEmployee} from "./api";
import axios from 'axios';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const EditEmployee=() => {
    //const [employee, setEmployee] = useState({})
    const [fname, setFName] = useState("");
    const [lname, setLName] = useState("");
    const [dob, setDob] = useState("");
    const [desig, setDesig] = useState("");
    const [email, setEmail] = useState("");
    const [doj, setDoj] = useState("");
    const [dept, setDept] = useState("");

    const navigate = useNavigate();
    const params=useParams();
    const idss = params.id;

    function formatDate(dateString) {
        const options = { year: 'numeric', month: '2-digit', day: '2-digit' };
        const date = new Date(dateString);
        return date.toLocaleDateString('en-GB', options);
      }
    useEffect(() => {
        return async ()=>{
        const result= await getById(idss);
        // const result = await axios.get(`http://localhost:8080/api/v1/employees/${params.id}`)
         //its supposed to be axios.get(.../params.id)
        //  console.log(result);
         //setEmployee(result);
        //  setTimeout(() => {
         console.log(result);

        setFName(result.firstName);
         setLName(result.lastName);
         setDob(result.dob);
         setDept(result.deparment);
         setEmail(result.emailId);
         setDoj(result.doj);
         setDesig(result.designation);
         console.log("suma");
        //  }, 3000);
         
        }
    }, []);

    const onFirstNameChange = (e) => {
        setFName(e.target.value);
    };
    const onLastNameChange = (e) => {
        setLName(e.target.value);
    };
    const onDeptChange = (e) => {
        setDept(e.target.value);
    };
    const onDesigChange = (e) => {
        setDesig(e.target.value);
    };
    const onEmailChange = (e) => {
        setEmail(e.target.value);
    };
    const onDojChange = (e) => {
        setDoj(e.target.value);
    };
    const onDobChange = (e) => {
        setDob(e.target.value);
    };

    const handleUpdateEmployee = async (e) => {
        console.log(employee);
        e.preventDefault();
        var employee = {
            // "firstName" : fname,
            // "lastName" : lname,
            // "department" : dept,
            // designation : desig,
            // emailId : email,
            // doj : doj,
            // dob : dob,
            firstName:fname,lastName:lname,designation:desig,
            deparment:dept,emailId:email,dob:dob,doj:doj,
        };
        // firstName:firstname,lastName:lastname,designation:desig,
        //     deparment:department,emailId:mail,dob:dob,doj:doj
        console.log(employee);
        const resp = await updateEmployee(idss,employee);
        toast.success(`Updated ${fname}'s details!`);
        navigate("/admin/list");
    };

    return (
        <div className="container" style={{"padding":"10%"}}><center>
            <h3 className="text-success">Update Employee {fname}</h3>
            <br></br>
            <br></br>
            <form className="col-4">
                <div class="form-outline mb-4 form-group">
                    <input type="text" className="form-control" 
                    placeholder="First Name" onChange={onFirstNameChange} value={fname} />
                </div>
                <div class="form-outline mb-4 form-group">
                    <input type="text" className="form-control" 
                    placeholder="Last Name" onChange={onLastNameChange} value={lname} />
                </div>
                <div class="form-outline mb-4 form-group">                   
                    <input type="text" className="form-control" 
                    placeholder="Department" onChange={onDeptChange} value={dept} />
                </div>
                <div class="form-outline mb-4 form-group">
                    <input type="text" placeholder="Designation"
                        className="form-control" onChange={onDesigChange} value={desig}
                    />
                </div>
                <div class="form-outline mb-4 form-group">
                    <input
                        type="email" placeholder="Email Id"
                        className="form-control"
                        onChange={onEmailChange} value={email}
                    />
                </div>
                <div class="form-outline mb-4 form-group">
                    <input type="text" className="form-control" 
                    placeholder="Date Of Joining(YYYY-MM-DD)" onChange={onDojChange}  value={doj.toLocaleDateString()}/>
                </div>
                <div class="form-outline mb-4 form-group">
                    <input type="text" className="form-control" 
                    placeholder="Date Of Birth(YYYY-MM-DD)" onChange={onDobChange}  value={dob.toLocaleDateString()}/>
                </div>
                <br />
                <button className="btn btn-success" onClick={handleUpdateEmployee}>Update Employee</button>
            </form></center>
            <ToastContainer
position="top-center"
autoClose={1000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
/>
        </div>
    );
};

export default EditEmployee;