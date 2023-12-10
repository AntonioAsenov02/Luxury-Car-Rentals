document.addEventListener('DOMContentLoaded', function() {
    let carIdElement = document.getElementById('carId');
    let carId = carIdElement ? carIdElement.getAttribute('value') : null;
    let reviewSection = document.getElementById('reviews-container');

    // Check if carId is available
    if (carId) {
        fetchReviews(carId); // Call fetchReviews with the obtained carId
    } else {
        console.error('Car ID not found.');
    }

    function fetchReviews(carId) {
        fetch(`http://localhost:8080/cars/details/api/reviews/${carId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch reviews');
                }
                return response.json();
            })
            .then(reviews => {
                console.log('Fetched reviews:', reviews); // Check if reviews are fetched successfully
                displayReviews(reviews);
            })
            .catch(error => {
                console.error('Error fetching reviews:', error);
            });

        function displayReviews(reviews) {
            reviewSection.innerHTML = '';

            reviews.forEach(function (review) {
                const user = review.firstName + ' ' + review.lastName;
                const date = review.postedOn;
                const userImageUrl = review.imageUrl;
                const rating = review.rating;
                const comment = review.text;

                const reviewHtml = '<div class="col-md-7">' +
                    '<h3 class="head">' + (user || 'Unknown User') + '</h3>' +
                    '<div class="review d-flex">' +
                    '<div class="user-img" style="background-image: url(' + (userImageUrl || '') + ')"></div>' +
                    '<div class="desc">' +
                    '<h4>' +
                    '<span class="text-left">' + (user || 'Unknown User') + '</span>' +
                    '<span class="text-right">' + (date || 'Unknown Date') + '</span>' +
                    '</h4>' +
                    '<p class="star">' +
                    '<span>' + generateStars(rating) + '</span>' +
                    '<span class="text-right"><a href="#" class="reply"><i class="fa-solid fa-star"></i></a></span>' +
                    '</p>' +
                    '<p>' + (comment || '') + '</p>' +
                    '</div>' +
                    '</div>' +
                    '</div>';

                reviewSection.innerHTML += reviewHtml;
            });
        }

        function generateStars(rating) {
            let stars = '';
            for (let i = 0; i < rating; i++) {
                stars += '<i class="fa-solid fa-star"></i>';
            }
            return stars;
        }
    }
});