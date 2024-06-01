import Note from './Components/Note.jsx'
import '@fortawesome/fontawesome-free/css/all.min.css';

function App() {

  const noteComponents = [];

  for (let i = 0; i < 1; i++) {
    noteComponents.push(<Note key={i}></Note>);
  }
  return (
    <>

      {noteComponents}
    </>
  )
}

export default App
