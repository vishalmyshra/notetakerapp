import React from 'react';
import '../css/Loading.css'; // Ensure the path to your CSS file is correct

const Loading = () => {
    return (
        <div className="loading-overlay">
            <div className="loading-dots">
                <div className="dot"></div>
                <div className="dot"></div>
                <div className="dot"></div>
            </div>
            <div className="loading-message">Please wait while performing operation...</div>
        </div>
    );
};

export default Loading;
