import React, {Component} from 'react';
import ReactDOM from 'react-dom';

import Header from './layout/Header'
import LoginForm from './login/LoginForm'
class App extends Component {
    render() {
        return (
            <div style={{ height: '1200px' }}>
                <Header />
                <LoginForm />
            </div>
        )
    }
}

ReactDOM.render(<App />, document.getElementById('app'))