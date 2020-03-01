import React, {Component} from 'react';
import ReactDOM from 'react-dom';

import Header from './layout/Header'
import PatientInfo from './layout/PatientInfo'
class App extends Component {
    render() {
        return (
            <div style={{ height: '1200px' }}>
                <Header />
                <PatientInfo />
            </div>
        )
    }
}

ReactDOM.render(<App />, document.getElementById('app'))