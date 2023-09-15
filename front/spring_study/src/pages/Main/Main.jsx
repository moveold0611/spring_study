import React, { useEffect, useState } from 'react';
import { deleteUser, getUserListAll, registerUser, updateUser } from '../../api/users';

function Main(props) {
    const emptyUser = {
        userId: "",
        username: "",
        name: "",
        phone: ""
    }
    const [ userInput, setUserInput ] = useState({
        userId: "",
        username: "",
        name: "",
        phone: ""
    });
    const [ mode, setMode ] = useState(1);
    // 비활성화 0, 계정추가중 1, 계정수정중 2

    const [ userList, setUserList ] = useState([]);

    const requestGetUserListAll = () => {
        getUserListAll()
        .then(response => {            
            setUserList(response.data);
        });
    }

    useEffect(() => 
        requestGetUserListAll()
        , []);

    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput,
            [e.target.name] : e.target.value
        });
    }

    const reSetting = () => {
        setUserInput(emptyUser);
        setMode(0);
        requestGetUserListAll();
    }

    const handleSelectClick = (user) => {
        setMode(2);
        setUserInput(user);
    }

    const handleRegisterClick = async () => {
        try {
            if(userInput.username=== "" &&
                userInput.name === "" &&
                userInput.phone === "") {
                alert("계정 정보를 입력하세요.")
                return;
            }
            await registerUser(userInput);
            reSetting();
        } catch (error) {
            if(error.response.status===404) {
                alert("[계정 추가 실패] 이미 존재하는 아이디입니다.")
                reSetting();
                return;
            } 
            alert("[계정 추가 실패] 오류가 발생하였습니다.")
            reSetting();
        }
    }

    const handleRegisterToggleClick = () => {
        setMode(1);
        setUserInput(emptyUser);
    }

    const handleUpdateClick = async () => {
        try {
            await updateUser(userInput);
            reSetting();
        } catch (error) {
            alert("[계정 정보 수정 실패] 오류가 발생하였습니다.")
            reSetting();
        }
    }

    const handleDeleteClick = async () => {
        try {
            await deleteUser(userInput) //
            reSetting();
        } catch (error) {
            alert("[계정 삭제 실패] 사용자 정보가 일치하지 않습니다.")
            reSetting();
        }
    }

    return (
        <div>
            <div><input type="text" disabled value={userInput.userId} name='userId' placeholder='userId' onChange={handleUserInputChange}/></div>
            <div><input type="text" disabled={mode === 0} value={userInput.username} name='username' placeholder='username' onChange={handleUserInputChange}/></div>
            <div><input type="text" disabled={mode === 0} value={userInput.name} name='name' placeholder='name' onChange={handleUserInputChange}/></div>
            <div><input type="text" disabled={mode === 0} value={userInput.phone} name='phone' placeholder='phone' onChange={handleUserInputChange}/></div>
            {mode === 1 ? 
            <button onClick={handleRegisterClick}>확인</button> 
            : <button onClick={handleRegisterToggleClick}>등록하기</button>}
            <button disabled={mode !== 2} onClick={handleUpdateClick}>수정하기</button>
            <button disabled={mode !== 2} onClick={handleDeleteClick}>삭제하기</button>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>사용자명</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th>선택</th>                        
                        </tr>
                    </thead>
                    <tbody>
                        {userList.map(user => 
                            <tr key={user?.userId}>
                                <td>{user?.userId}</td>
                                <td>{user?.username}</td>
                                <td>{user?.name}</td>
                                <td>{user?.phone}</td>
                                <td><button onClick={() => handleSelectClick(user)}>✔</button></td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Main;