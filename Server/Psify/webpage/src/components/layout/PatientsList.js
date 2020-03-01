import React, {Component} from 'react';

class PatientsList extends Component {
    render() {
        return (
            <div class="list-group" style={{ position: 'absolute', left: '50%', top: '50%', transform: 'translate(-50%, -50%)', width: '75%'}}>
                <div class="list-group-item list-group-item-action">
                    <a href="#">Pacjent 1</a>
                    <button type="button" class="btn btn-primary" style={{ position: 'absolute', right: '0%', top: '0%', height: '100%' }}>
                        Alert! <span class="badge badge-secondary">4</span>
                    </button>
                </div>
                 
                <div class="list-group-item list-group-item-action">
                    <a href="#">Pacjent 2</a>
                    <button type="button" class="btn btn-primary" style={{ position: 'absolute', right: '0%', top: '0%', height: '100%' }}>
                        Alert! <span class="badge badge-secondary">3</span>
                    </button>
                </div>
               
                <div class="list-group-item list-group-item-action">
                    <a href="#">Pacjent 3</a>
                    <button type="button" class="btn btn-primary" style={{ position: 'absolute', right: '0%', top: '0%', height: '100%' }}>
                        Alert! <span class="badge badge-secondary">4</span>
                    </button>
                </div>
            </div>
        )
    }
}

export default PatientsList