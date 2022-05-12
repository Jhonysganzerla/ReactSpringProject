import React from "react";
import { Route, Routes } from "react-router-dom";
import NavBar from "../components/NavBar";
import ContaPageList from "../pages/Conta/ContaPageList";
import HomePage from "../pages/HomePage/HomePage";

const AuthenticatedRoutes = () => {
    return (
        <div>
            <NavBar/>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/contas" element={<ContaPageList />} />
                <Route path="/*" element={<HomePage />} />
            </Routes>
        </div>
    );
}
export default AuthenticatedRoutes;