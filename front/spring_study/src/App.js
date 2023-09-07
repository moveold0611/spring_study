import React from "react";
import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main/Main";
import List from "./pages/List/List";
import Modification from "./pages/Modification/Modification";
import Register from "./pages/Register/Register";
import Remove from "./pages/Remove/Remove";

function App() {

  return (
    <>
    <Routes>
      <Route path="/" element={<Main />}/>
      <Route path="/list" element={<List />}/>
      <Route path="/modification" element={<Modification />}/>
      <Route path="/register" element={<Register />}/>
      <Route path="/remove" element={<Remove />}/>
    </Routes>
    </>
  );
}

export default App;
