import axios from 'axios';


async function saveNote({ noteContent, noteAuthorId }) {

    try {
        let usernameSet = "", emailSet = "";
        if (noteAuthorId == '123457') {
            usernameSet = "ashish";
            emailSet = "ashish.zen@gmail.com"

        }
        if (noteAuthorId == '123458') {
            usernameSet = "ankur";
            emailSet = "ankurmishra1226@gmail.com"

        }
        if (noteAuthorId == '') {
            noteAuthorId = "1234";
        }

        if (noteContent == '' || noteContent == null) {
            alert("No data present.")
            return;
        }
        const response = await axios.post('http://localhost:9090/notesbackend/note', {
            noteAuthorId: noteAuthorId,
            noteContent: noteContent,

            user: {
                userId: noteAuthorId,
                username: usernameSet,
                email: emailSet
            }
        });
        console.log('Note saved successfully:', response.status);
        if (response.status == 200) {
            window.alert("Note saved successfully.")
        }

    } catch (error) {
        console.error('There was an error saving the note!', error);
        window.alert("There was some error while saving the note, Please check with your admin.")
        return;
    }
}

export default saveNote