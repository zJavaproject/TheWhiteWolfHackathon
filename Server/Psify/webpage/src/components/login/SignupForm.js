import React, {Component, TextField} from 'react';

class SignupForm extends Component {
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
                <p>Zarejestruj się do MindCare</p>
                <form class="needs-validation" novalidate onSubmit={this.validateForms.bind(this)}>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Imię" id="nameValidator" required />
                        <div class="invalid-feedback">
                            Niepoprawne imię!
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Nazwisko" id="surnameValidator" required />
                        <div class="invalid-feedback">
                            Niepoprawne nazwisko!
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Email" id="mailValidator" required />
                        <div class="invalid-feedback">
                            Niepoprawny email!
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Hasło" id="passwordValidator" required />
                        <div class="invalid-feedback">
                            Niepoprawne hasło!
                        </div>
                    </div>
                    <div class="form-group row">
                        <input type="text" class="form-control" placeholder="Numer certyfikatu" id="certValidator" required />
                        <div class="invalid-feedback">
                            Niepoprawny numer!
                        </div>
                    </div>
                    <div class="form-group row">
                        <select class="custom-select" required>
                            <option selected>Wybierz profesję</option>
                            <option value="psychoterapeuta">Psychoterapeuta</option>
                            <option value="psycholog">Psycholog</option>
                            <option value="psychiatra">Psychiatra</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <button type="submit" class="btn btn-primary">Zarejestruj się</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default SignupForm