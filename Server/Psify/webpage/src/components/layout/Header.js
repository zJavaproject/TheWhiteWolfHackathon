import React, {Component} from 'react';

class Header extends Component {
    render() {
        return (
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active"><a href="#" aria-current="page">Strona główna</a></li>
                </ol>
            </nav>
        )
    }
}

export default Header