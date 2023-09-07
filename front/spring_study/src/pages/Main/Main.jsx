import React, { useState } from 'react';
import { deleteUser, registerUser, updateUser } from '../../api/users';

function Main(props) {
    // console.log("Debug");
    const [ userInput, setUserInput ] = useState({
        userId: "",
        username: "",
        name: "",
        phone: ""
    }); 

    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput,
            [e.target.name] : e.target.value
        });
    }

    const handleRegisterClick = () => {
        registerUser(userInput);
    }

    const handleUpdateClick = () => {
        updateUser(userInput);
    }

    const handleDeleteClick = () => {
        deleteUser(userInput);
    }

    return (
        <div>
            <div><input type="text" name='userId' placeholder='userId' onChange={handleUserInputChange}/></div>
            <div><input type="text" name='username' placeholder='username' onChange={handleUserInputChange}/></div>
            <div><input type="text" name='name' placeholder='name' onChange={handleUserInputChange}/></div>
            <div><input type="text" name='phone' placeholder='phone' onChange={handleUserInputChange}/></div>
            <button onClick={handleRegisterClick}>추가하기</button>
            <button onClick={handleUpdateClick}>수정하기</button>
            <button onClick={handleDeleteClick}>삭제하기</button>
        </div>
    );
}

export default Main;