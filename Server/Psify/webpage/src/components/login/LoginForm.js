import React, {Component, TextField} from 'react';

class Form extends Component {
    validateForms() {
        window.addEventListener('load', function() {
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
            });
        }, false);
    }

    render() {
        return (
            <div style={{ position: 'absolute', left: '50%', top: '50%', transform: 'translate(-50%, -50%)', width: '500px' }}>
                <p>Logowanie do MindCare</p>
                <form class="needs-validation" novalidate onSubmit={this.validateForms.bind(this)}>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Login" id="loginValidation" required />
                        <div class="invalid-feedback">
                            Niepoprawny login!
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Password" id="passwordValidation" required />
                        <div class="invalid-feedback">
                            Niepoprawne hasło!
                        </div>
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default Form