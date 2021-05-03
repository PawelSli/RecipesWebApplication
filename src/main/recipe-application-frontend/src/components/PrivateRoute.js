import React from 'react'
import AuthService from "../services/auth.service";
import { Redirect, Route } from 'react-router-dom';

const PrivateRoute = ({ component: Component, ...rest }) => {

    const isLoggedIn = AuthService.isLogged()

    return (
        <Route
            {...rest}
            render={props =>
                isLoggedIn ? (
                    <Component {...props} />
                ) : (
                    <Redirect to={{ pathname: '/api/auth/signin', state: { from: props.location } }} />
                )
            }
        />
    )
}

export default PrivateRoute;