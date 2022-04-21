import React from "react";
import Input from '../../components/input';
import axios from "axios";
import { Button, Alert } from "react-bootstrap";

export class UserSignupPage extends React.Component {

    state = {
        displayname: '',
        username: '',
        password: '',
        passwordRepeat: '',
        pendingApiCall: false,
        errors: {},
        successMessage: '',
    }

    onChangeDisplayName = (event) => {
        const value = event.target.value;
        this.setState({ displayname: value });
    }

    onChangeUsername = (event) => {
        const value = event.target.value;
        this.setState({ username: value });
    }

    onChangePassword = (event) => {
        const value = event.target.value;
        this.setState({ password: value });
    }
    onChangePasswordRepeat = (event) => {
        const value = event.target.value;
        this.setState({ passwordRepeat: value });
    }

    
    onClickSignup = () => {
        const user = {
            displayname: this.state.displayname,
            username: this.state.username,
            password: this.state.password,
        }
        this.setState({ pendingApiCall: true });
        this.saveUser(user).then(response => {
            console.log(response.data.message);
            this.state.errors = {};
            this.setState({ pendingApiCall: false });
        })
            .catch(apiError => {

            console.log(apiError)

                let errors = { ...this.state.errors }
                if (apiError.response.data && apiError.response.data.validationErrors) {
                    errors = { ...apiError.response.data.validationErrors }
                }
                this.setState({ pendingApiCall: false, errors });
            });

    }

    saveUser = (user) => {
        return axios.post('/users/signup', user);
    } 

    render() {
        return (
            <div className="container">
                {this.state.successMessage != '' && (<Alert variant="success" onClose={() => this.state.successMessage != ''} dismissible>
                        <Alert.Heading>Oh não! Ocorreu um erro!, mas deve ta verde</Alert.Heading>
                </Alert>)}

                <h1 >Sign Up</h1>
                <div className="col-4 mb-3">
                    <Input
                        label="Informe o seu nome"
                        type="text"
                        placeholder="Informe o seu nome"
                        value={this.state.displayname}
                        onChange={this.onChangeDisplayName}
                        hasError={this.state.errors.displayname && true}
                        error={this.state.errors.displayname}
                    />

                </div>
                <div className="col-4 mb-3">
                    <Input className="form-control"
                        label="Informe o usuário"
                        type="text" placeholder="Informe o usuário"
                        value={this.state.username}
                        onChange={this.onChangeUsername}   
                        hasError={this.state.errors.username && true}
                        error={this.state.errors.username}/>
                </div>
                <div className="col-4 mb-3">
                    <Input className="form-control"
                    label="Informe a sua senha"
                        type="password" placeholder="Informe a sua senha"
                        value={this.state.password}
                        onChange={this.onChangePassword} 
                        hasError={this.state.errors.password && true}
                        error={this.state.errors.password}
                        />
                </div>
                <div className="col-4 mb-3">
                    <Input className="form-control"
                        label="Repita a sua senha"
                        type="password" placeholder="Confirme sua senha"
                        value={this.state.passwordRepeat}
                        onChange={this.onChangePasswordRepeat}  
                        hasError={this.state.errors.password && true}
                        error={this.state.errors.password} />
                </div>
                <div>
                    <Button variant="primary" 
                        disabled={this.state.pendingApiCall}
                        onClick={this.onClickSignup}
                    >
                        {this.state.pendingApiCall && (
                            <div className="spinner-border text-light spinner-border-sm mr-sm-1"
                                role="status">
                                <span className="visually-hidden">Aguarde...</span>
                            </div>
                        )}
                        Cadastrar
                    </Button >
                </div>
            </div>
        )
    }
}

UserSignupPage.defaultProps = {
    actions: {
        postSignup: () =>
            new Promise((resolve, reject) => {
                resolve({});
            }),
    }
}
export default UserSignupPage;