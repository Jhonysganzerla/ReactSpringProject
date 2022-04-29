import React, { useState } from "react";
import Input from '../../components/input';
import ButtonWithProgress from '../../components/buttonWithProgress';

import axios from "axios";
import { Button, Alert } from "react-bootstrap";
import AuthService from "../../services/Auth/auth.service";
import { Link, useNavigate } from "react-router-dom";

export const UserSignupPage = (props) => {

    const [form, setForm] = useState({
        displayname: '',
        username: '',
        password: '',
        passwordRepeat: '',
    });

    const [pendingApiCall, setPendingApiCall] = useState(false);
    const [errors, setErrors] = useState({});
    const [successMessage, setSuccessMessage] = useState('');

    const navigate = useNavigate();

    const onChange = (event) => {
        const { value, name } = event.target;

        setForm((previousForm) => {
            return {
                ...previousForm,
                [name]: value,
            };
        });

        setErrors((previousErrors) => {
            return {
                ...previousErrors,
                [name]: undefined,
            };
        });
    };


    const onClickSignup = () => {
        const user = {
            displayname: form.displayname,
            username: form.username,
            password: form.password,
        }
        setPendingApiCall(true);
        AuthService.saveUser(user).then(response => {
            form.errors = {};
            setPendingApiCall(false);
            navigate('/');
        })
            .catch(apiError => {

                let errors = { ...errors }
                if (apiError.response.data && apiError.response.data.validationErrors) {
                    errors = { ...apiError.response.data.validationErrors }
                }
                setPendingApiCall(true);
                setErrors(errors);
            });
    }

    let passwordRepeatError;
    const { password, passwordRepeat } = form;
    if (password || passwordRepeat) {
        passwordRepeatError = password === passwordRepeat ? '' : 'As senhas devem ser iguais';
    }

    return (
        <div className="container">
            {successMessage != '' && (<Alert variant="success" onClose={() => successMessage != ''} dismissible>
                <Alert.Heading>Oh não! Ocorreu um erro!, mas deve ta verde</Alert.Heading>
            </Alert>)}

            <h1 >Sign Up</h1>
            <div className="text-center col-12 mb-3">
                <div className="col-4">
                    <Input
                        name="displayname"
                        label="Informe o seu nome"
                        type="text"
                        placeholder="Informe o seu nome"
                        value={form.displayname}
                        onChange={onChange}
                        hasError={errors.displayname && true}
                        error={errors.displayname}
                    />
                </div>

            </div>
            <div className="text-center col-12 mb-3">
                <div className="col-4">
                    <Input
                        name="username"
                        label="Informe o usuário"
                        type="text"
                        placeholder="Informe o usuário"
                        value={form.username}
                        onChange={onChange}
                        hasError={errors.username && true}
                        error={errors.username} />
                </div>
            </div>
            <div className="text-center col-12 mb-3">
                <div className="col-4">
                    <Input
                        name="password"
                        label="Informe a sua senha"
                        type="password" 
                        placeholder="Informe a sua senha"
                        value={form.password}
                        onChange={onChange}
                        hasError={errors.password && true}
                        error={errors.password}
                    />
                </div>
            </div>
            <div className="text-center col-12 mb-3">
                <div className="col-4">
                    <Input
                        name="passwordRepeat"
                        label="Repita a sua senha"
                        type="password" placeholder="Confirme sua senha"
                        value={form.passwordRepeat}
                        onChange={onChange}
                        hasError={passwordRepeatError && true}
                        error={errors.password} />
                </div>
            </div>
            <div className="text-center">
                <ButtonWithProgress
                    disabled={pendingApiCall || passwordRepeatError ? true : false}
                    onClick={onClickSignup}
                    pendingApiCall={pendingApiCall}
                    text="Cadastrar"
                />
            </div>
            <div className='text-center'>
                já possui cadastro? <Link to="/">Login</Link>
            </div>
        </div>
    )
};

export default UserSignupPage;