import React, {Component} from 'react';

class Header extends Component {
    render() {
        return (
            <nav class="navbar navbar-expand-lg navbar-light bg-light" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="nav-item">MindCare</li>
                    <li class="breadcrumb-item active"><a href="#" aria-current="page">Strona główna</a></li>
                </ol>
            </nav>
        )
    }
}

export default Header