import React, { useState } from "react";
import Input from '../../components/input';
import ButtonWithProgress from '../../components/buttonWithProgress';

import axios from "axios";
import { Button, Alert } from "react-bootstrap";
import AuthService from "../../services/Auth/auth.service";

export const UserSignupPage = (props) => {

    const [form, setForm] = useState({
        displayname: '',
        username: '',
        password: '',
        passwordRepeat: '',
    });

    const [pendingApiCall, setPendingApiCall ] = useState(false);
    const [errors, setErrors] = useState({});
    const [successMessage, setSuccessMessage] = useState('');

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
            console.log(response.data.message);
            form.errors = {};
            setPendingApiCall(false);
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
                {successMessage != '' && (<Alert variant="success" onClose={() => form.successMessage != ''} dismissible>
                        <Alert.Heading>Oh não! Ocorreu um erro!, mas deve ta verde</Alert.Heading>
                </Alert>)}

                <h1 >Sign Up</h1>
                <div className="col-4 mb-3">
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
                <div className="col-4 mb-3">
                    <Input className="form-control"
                        name="username"
                        label="Informe o usuário"
                        type="text" placeholder="Informe o usuário"
                        value={form.username}
                        onChange={onChange}
                        hasError={errors.username && true}
                        error={errors.username}/>
                </div>
                <div className="col-4 mb-3">
                    <Input className="form-control"
                        name="password"
                        label="Informe a sua senha"
                        type="password" placeholder="Informe a sua senha"
                        value={form.password}
                        onChange={onChange}
                        hasError={errors.password && true}
                        error={errors.password}
                        />
                </div>
                <div className="col-4 mb-3">
                    <Input className="form-control"
                        name="passwordRepeat"
                        label="Repita a sua senha"
                        type="password" placeholder="Confirme sua senha"
                        value={form.passwordRepeat}
                        onChange={onChange}
                        hasError={passwordRepeatError && true}
                        error={errors.password} />
                </div>
                <div className="text-center">
                    <ButtonWithProgress
                        disabled={pendingApiCall || passwordRepeatError ? true : false}
                        onClick={onClickSignup}
                        pendingApiCall={pendingApiCall}
                        text="Cadastrar"
                    />
                </div>
            </div>
        )
    };

UserSignupPage.defaultProps = {
    actions: {
        postSignup: () =>
            new Promise((resolve, reject) => {
                resolve({});
            }),
    }
}

export default UserSignupPage;