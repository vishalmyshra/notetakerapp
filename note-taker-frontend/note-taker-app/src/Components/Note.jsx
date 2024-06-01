import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css'; // Ensure this import is present
import saveNote from '../dbconnection/dbOrFetch';
import AuthorDropDown from './AuthorDropDown';
import Loading from './Loading';

function Note() {
    const [textContent, setTextContent] = useState('');
    const [previousNoteContent, setPreviousNoteContent] = useState('');
    const [selectedAuthorId, setSelectedAuthorId] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const savedContent = localStorage.getItem('notecontent');
        if (savedContent) {
            setPreviousNoteContent(savedContent);
        }
    }, []);

    useEffect(() => {
        localStorage.setItem('notecontent', textContent);
    }, [textContent]);

    function handleTextArea(event) {
        setTextContent(event.target.value);
    }

    function resetNoteData() {
        if (!textContent && !previousNoteContent) {
            alert("There is nothing to reset.");
            return;
        }
        let confirmation = window.confirm("Are you sure?");
        if (confirmation) {
            setTextContent('');
            if (previousNoteContent) {
                localStorage.clear('notecontent');
            }
            setPreviousNoteContent('');
        }
    }

    async function handleSaveNote() {
        setIsLoading(true);
        await saveNote({
            noteContent: textContent,
            noteAuthorId: selectedAuthorId
        });
        setIsLoading(false);
    }

    return (
        <div className="container d-flex justify-content-center align-items-center" style={{ minHeight: '100vh' }}>
            <div className="card">
                <div className="card-header">Note</div>
                <div className="card-body">
                    <textarea onChange={handleTextArea} className='text-area form-control' value={textContent}></textarea>
                </div>
                <div className="card-footer">
                    <AuthorDropDown setSelectedAuthorId={setSelectedAuthorId} />
                    <button className="btn btn-danger"><i className="fas fa-trash"></i></button>
                    <button className="btn btn-success" onClick={handleSaveNote}><i className="fas fa-save"></i></button>
                    <button className="btn btn-primary" onClick={resetNoteData}><i className="fas fa-undo"></i></button>
                </div>
            </div>
            {isLoading && <Loading />}
        </div>
    );
}

export default Note;
