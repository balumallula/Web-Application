/**
 * 
 */
   //password validation 
        document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('passwordForm');
    const passwordInput = document.getElementById('password');
    const strengthMessage = document.getElementById('strengthMessage');

    

    passwordInput.addEventListener('input', () => {
        const password = passwordInput.value;
        const strength = getPasswordStrength(password);

        strengthMessage.style.display = 'block';
        strengthMessage.textContent = `  ${strength}`;
        strengthMessage.className = `message ${strength.toLowerCase()}`;
    });

    function getPasswordStrength(password) {
        const minLength = 6;
        const hasLowerCase = /[a-z]/.test(password);
        const hasUpperCase = /[A-Z]/.test(password);
        const hasNumber = /\d/.test(password);
        const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);

        if (password.length >= minLength && hasLowerCase && hasUpperCase && hasNumber && hasSpecialChar) {
            return 'Strong';
        } else if (password.length >= minLength && ((hasLowerCase && hasUpperCase) || (hasLowerCase && hasNumber) || (hasUpperCase && hasNumber) || (hasLowerCase && hasSpecialChar) || (hasUpperCase && hasSpecialChar) || (hasNumber && hasSpecialChar))) {
            return 'Medium';
        } else {
            return 'Weak';
        }
    }
});/**
 * 
 */