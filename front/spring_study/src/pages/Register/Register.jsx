import React, { useState } from 'react';



function Register(props) {
    const [ dummy, setDummy ] = useState(); 

    const handleOnchange = (e) => {

    }


    return (
        <div>
            <div><input type="text" name='username' placeholder='username' onChange={handleOnchange}/></div>
            <div><input type="text" name='password' placeholder='password' onChange={handleOnchange}/></div>
            <div><input type="text" name='name' placeholder='name' onChange={handleOnchange}/></div>
            <div><input type="text" name='email' placeholder='email' onChange={handleOnchange}/></div>
            <button>추가하기</button>
        </div>
    );
}

export default Register;