// SplashScreen.js
import React, { useEffect } from 'react';
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const SplashScreen = ({ setRedirect }) => {
  useEffect(() => {
    const timer = setTimeout(() => {
      setRedirect(true); // Set the redirect flag to true after 3 seconds
    }, 3000); // 3 seconds in milliseconds

    return () => {
      clearTimeout(timer); // Clear the timer if the component unmounts
    };
  }, [setRedirect]);

  return (
    <div className="splash-screen">
      <h1>Loading...</h1>
      {/* You can add your branding/logo or any other content here */}
    </div>
  );
};

export default SplashScreen;
