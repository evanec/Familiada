import React, { Component } from "react";
import ReactDOM from 'react-dom';
import '../css/Main.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Main extends Component {
    render() {
        return (
            <div id="main">
                <h1>Demo Compttrsonent</h1>
<div class="spinner-border" role="status">
  <span class="sr-only">Loading...</span>
</div>
            </div>
        );
    }
}

ReactDOM.render(
    <Main />,
    document.getElementById('react-mountpoint')
);