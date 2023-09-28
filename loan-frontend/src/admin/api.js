import axios, { AxiosError } from "axios";
const addEmployee = async (employee) => {
  const response = await axios.post(
    "http://localhost:8080/api/v1/employees",
    employee
  );
};

const getById=async (id)=>{
    const response=await axios.get(`http://localhost:8080/api/v1/employees/${id}`)
    return response.data;
}

const deleteEmployee=async (id)=>{
   const response= await axios.delete(`http://localhost:8080/api/v1/employees/${id}`);
}

const getAll = async () => {
  const response = await axios.get("http://localhost:8080/api/v1/employees");
  console.log("This is from get All", response.data);
  return response.data;
};

const updateEmployee = async (id, employee) => {
  try {
    const res = await axios.put(`http://localhost:8080/api/v1/employees/${id}`, employee);
    return res.data;
  } catch (error) {
    if (error.response) {
      console.error("Server responded with a non-2xx status:", error.response.status);
      console.error("Response data:", error.response.data);
    } else if (error.request) {
      console.error("No response received from the server.");
    } else {
      console.error("An error occurred while making the request:", error.message);
    }
    throw error; // Re-throw the error for the caller to handle
  }
};


export { addEmployee, getAll, deleteEmployee, getById, updateEmployee };