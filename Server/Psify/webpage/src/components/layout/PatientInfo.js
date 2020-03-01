import React, {Component} from 'react';
import Table from 'react-bootstrap/Table';

class PatientInfo extends Component {
    render() {
        return (
            <div style={{ position: 'relative', left: '50%', top: '40%', transform: 'translate(-50%, -50%)', width: '75%', display: 'flex' }}>
                <p>    
                    <h1>Jan Kowalski</h1>
                    <span>Numer telefonu: 666 666 666<br /> </span>
                    <span>Email: jan.kowalski@kowal.pl<br /> </span>
                    <span>Diagnoza: Agorafobia<br /></span>
                    <div>Ataki paniki: <br />
                        <Table>
                            <thead>
                                <tr>
                                    <th>Czas rozpoczęcia</th>
                                    <th>Czas zakończenia</th>
                                    <th>Komentarz</th>
                                    <th>Pytania</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>20.02.2020 17:30:32</td>
                                    <td>20.02.2020 18:03:39</td>
                                    <td>Narastające poczucie osaczenia, wrażenie napierania ścian</td>
                                    <td>Dlaczego tak mam, mimo że nie powinienem, gdyż byłem na świeżym powietrzu?</td>
                                </tr>
                                <tr>
                                    <td>20.02.2020 17:30:32</td>
                                    <td>20.02.2020 18:03:39</td>
                                    <td>Narastające poczucie osaczenia, wrażenie napierania ścian</td>
                                    <td>Dlaczego tak mam, mimo że nie powinienem, gdyż byłem na świeżym powietrzu?</td>
                                </tr>
                                <tr>
                                    <td>20.02.2020 17:30:32</td>
                                    <td>20.02.2020 18:03:39</td>
                                    <td>Narastające poczucie osaczenia, wrażenie napierania ścian</td>
                                    <td>Dlaczego tak mam, mimo że nie powinienem, gdyż byłem na świeżym powietrzu?</td>
                                </tr>
                                <tr>
                                    <td>20.02.2020 17:30:32</td>
                                    <td>20.02.2020 18:03:39</td>
                                    <td>Narastające poczucie osaczenia, wrażenie napierania ścian</td>
                                    <td>Dlaczego tak mam, mimo że nie powinienem, gdyż byłem na świeżym powietrzu?</td>
                                </tr>
                            </tbody>
                        </Table>
                    </div>
                    <span>Notatki dotyczące pacjenta: <br /> 
                        Pacjent stabilny, z okazyjnymi atakami paniki, wywoływanymi przez wspomnienia.
                    </span>
                    <form>
                        <div class="form-group row">
                            <textarea class="form-control" placeholder="Dodaj uwagi" id="notes" rows="5"/>
                        </div>
                        <div class="form-group row">
                            <button type="submit" class="btn btn-primary">Dodaj uwagi</button>
                        </div>
                    </form>
                </p>
            </div>
        )
    }
}

export default PatientInfo