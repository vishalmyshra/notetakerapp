import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';

const AuthorDropDown = ({ setSelectedAuthorId }) => {
    const [selectedValue, setSelectedValue] = useState('Select Author');

    useEffect(() => {
        setSelectedValue(selectedValue);
    }, []);

    const handleChange = (e) => {
        const value = e.target.value;
        setSelectedValue(value);
        setSelectedAuthorId(value);
    };

    return (
        <div>
            <h6>Select a Name:</h6>
            <select value={selectedValue} onChange={handleChange}>
                <option value="#">Select Author</option>
                <option value="123457">Ashish</option>
                <option value="123456">Vishal</option>
                <option value="123458">Ankur</option>
            </select>

        </div>
    );
};
AuthorDropDown.propTypes = {
    setSelectedAuthorId: PropTypes.func.isRequired
};

export default AuthorDropDown;
