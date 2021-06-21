import React, { Component } from "react";
import ReactDOM from 'react-dom';
import '../css/Main.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Main extends Component {
    state = {
       isLoading: true,
       groups: []
     };

     async componentDidMount() {
       const response = await fetch('/api/groups');
       const body = await response.json();
       this.setState({ groups: body, isLoading: false });
     }

     render() {
       const {groups, isLoading} = this.state;

       if (isLoading) {
         return <p>Loading...</p>;
       }

       return (
         <div className="App">
           <header className="App-header">
             <img src={logo} className="App-logo" alt="logo" />
             <div className="App-intro">
               <h2>JUG List</h2>
               {groups.map(group =>
                 <div key={group.id}>
                   {group.name}
                 </div>
               )}
             </div>
           </header>
         </div>
       );
     }
}

ReactDOM.render(
    <Main />,
    document.getElementById('react-mountpoint')
);
