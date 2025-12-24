// Load confetti library dynamically
function loadConfetti(callback) {
    const script = document.createElement('script');
    script.src = 'https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js';
    script.onload = callback;
    document.body.appendChild(script);
}

// Play confetti
function playConfetti() {
    loadConfetti(() => {
        confetti({
            particleCount: 250,
            spread: 100,
            origin: { y: 0.6 }
        });
    });
}

// Automatically trigger confetti on page load
window.onload = () => {
    playConfetti();
    
    // Optional: fade in music if autoplay blocked
    const music = document.getElementById('bgMusic');
    music.volume = 0.5;
    const playPromise = music.play();
    if (playPromise !== undefined) {
        playPromise.catch(() => {
            // Autoplay blocked, show a play button if needed
            console.log("Autoplay blocked. User interaction required to play music.");
        });
    }
};
