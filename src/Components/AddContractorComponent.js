import React, { useState } from "react";
import ContractorService from "../Services/ContractorService";
import { useNavigate } from 'react-router-dom';
import OTPValidation from "./OTPValidation";

const AddContractorComponent = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [mobile, setMobile] = useState('');

  const [flag,setFlag] = useState(true);

  const navigate = useNavigate();

  const saveContractor = (e) => {
    e.preventDefault();
    const contractor = { username, password, email, mobile };
    
    ContractorService.signUp(contractor)
      .then((response) => {
        setFlag(true);
        console.log(response.data);
       
        navigate(`/verifyOtp?email=${encodeURIComponent(email)}`);
      })
      .catch(error => {
        console.log(error);
      });
  }

  return (
    <div>
      <section className="md-section" style={{ backgroundColor: "#fff", padding: "120px 0 0" }}>
        <div className="row">
          <div className="col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-2 ">
            <div className="sec-title sec-title__lg-title md-text-center">
              <h2 className="sec-title__title">Sign Up</h2><span className="sec-title__divider"></span>
            </div>
          </div>
        </div>
        <div className="container">
          <div className="row">
            <div className="col-lg-9  col-lg-push-3">
              <div className="main-content">
                <div className="row">
                  <div className="col-lg-6 ">
                    <form className="contact-form">
                      <div className="form-item">
                        <input className="form-control" type="text" name="email" value={email} placeholder="Enter email" onChange={(e) => setEmail(e.target.value)} />
                      </div>
                      <div className="form-item">
                        <input className="form-control" type="text" name="mobile" value={mobile} placeholder="Enter Mobile No" onChange={(e) => setMobile(e.target.value)} />
                      </div>
                      <div className="form-item">
                        <input className="form-control" type="text" name="username" value={username} placeholder="Enter Username" onChange={(e) => setUsername(e.target.value)} />
                      </div>
                      <div className="form-item">
                        <input className="form-control" type="password" value={password} name="password" placeholder="Enter Password" onChange={(e) => setPassword(e.target.value)} />
                      </div>
                      <button className="btn btn-primary btn-round mb-30" type="submit" onClick={saveContractor}>Submit</button>
                    </form>
                  </div>
                  <div className="col-lg-6">
                    <div className="contact-gmap">
                      <img src="assets/img/service/signup.jpg" alt="Using Memes in Your" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    
    </div>
  );
}

export default AddContractorComponent;
