import * as React from 'react';
import ClassDefault from './ClassDefault';
import { ClassNamed } from './ClassNamed';
import FunctionDefault from './FunctionDefault';
import { FunctionNamed } from './FunctionNamed';
import Button from 'react-bootstrap/Button';

const LazyComponent = React.lazy(() => import('./LazyComponent'));

function App() {
  return (
    <div>
      <ClassDefault />
      <ClassNamed />
      <FunctionDefault />
      <FunctionNamed />
      <React.Suspense fallback={<h1>Loading</h1>}>
        <LazyComponent />
      </React.Suspense>
      <Button variant="primary" onClick={toggleButtonState}> Primary</Button>
    </div>
  );
}

function toggleButtonState () {
fetch('http://localhost:8080/api/questions/', {
  method: 'POST',
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    firstParam: 'yourValue',
    secondParam: 'yourOtherValue'
  })
});

}


export default App;
