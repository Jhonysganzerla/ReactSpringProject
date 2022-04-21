import React from 'react';
import Input from '../../components/input';
import { Alert } from "react-bootstrap";
import ButtonWithProgress from '../../components/buttonWithProgress';


export class LoginPage extends React.Component {

    state = {
        username:'',
        password:'',
        apiError:undefined,
        pendingApiCall:false
    }

    onChangeUsername  = (ev) => { 
        const value = ev.target.value;
        this.setState({username:value , apiError:undefined});
    }

    onChangePassword  = (ev) => { 
        const value = ev.target.value;
        this.setState({password:value, apiError:undefined});
    }

    onClickLogin = () => {
        this.setState({pendingApiCall:true});
        const body = {
            username:this.state.username,
            password:this.state.password
        }

        this.props.actions.postLogin(body)
        .then(() => {
            this.setState({pendingApiCall:false});
        })
        .catch(err => {
            this.setState({apiError:err, pendingApiCall:false});
        });
    }

    dismissAlert = () => {
        this.setState({apiError:undefined});
    }

   render() { 
    let disableSubmit = false;
    
    if(this.state.username === '' || this.state.password === ''){
        disableSubmit = true;
    }

    return (
           <div className='container'>
               <h1 className='text-center'>Login</h1>
                <div className='col-12 mb-3'>
                    <Input 
                        label='Informe o usuário'
                        placeholder='Your username'
                        value={this.state.username}
                        onChange={this.onChangeUsername}
                    />
                </div>

                <div className='col-12 mb-3'>
                    <Input 
                        label='Informe a senha'
                        placeholder='Your password'
                        type='password'
                        value={this.state.password}
                        onChange={this.onChangePassword}
                    />
                </div>


                <div className='col-12 mb-3'> {
                    this.state.apiError != undefined && (
                    <Alert variant='danger' onClose={this.dismissAlert} dismissible>
                        <Alert.Heading>Oh poxa! Você recebeu um erro!</Alert.Heading>
                        <p>{this.state.apiError?.message}</p>
                    </Alert>
                    )
                }
                    
                </div>

                <div className='text-center'>
                <ButtonWithProgress  
                        disabled={this.state.pendingApiCall || disableSubmit}
                        onClick={this.onClickLogin}
                        text='Login'
                        pendingApiCall={this.state.pendingApiCall}
                    />
                </div>
           </div>
       )
   }
}

LoginPage.defaultProps = {
  actions: {
    postLogin: () => new Promise((resolve, reject) => resolve({}))
  }
};

export default LoginPage;