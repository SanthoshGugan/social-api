# The Social Media API

This repository contains the backend code for "The Social Media" application. It provides a set of APIs to support various social media functionalities. The API is built using the Java Spring framework and utilizes MongoDB as the database, hosted on the cloud using the free tier of MongoDB Atlas. The API is containerized in Docker for easy deployment.

## Features

1. User Authentication:
    - Users can sign up with a unique username and password.
    - Existing users can log in to access their account.

2. Post Management:
    - Users can create new posts.
    - Users can edit and delete their own posts.

3. Friend Management:
    - Users can add friends.
    - Users will receive recommendations for new friends.

4. News Feed:
    - Users will see posts from their friends in their news feed.

5. Comments:
    - Users can comment on their own or their friends' posts.
    - Users can edit and delete their own comments.

6. Likes:
    - Users can like posts.
    - Users can undo their likes on posts.
    - Each post will display the total number of likes.

## Tech Stack

The following technologies and tools are used in this project:

1. Java Spring Framework - Provides the foundation for building the API.
2. MongoDB - Hosted on the cloud using the free tier of MongoDB Atlas, it serves as the database.
3. Docker - The API is containerized for easy deployment and management.

## Getting Started

To run the API locally using Docker, follow these steps:

1. Clone this repository to your local machine.

2. Install Docker if you haven't already.

3. Open a terminal or command prompt and navigate to the project's root directory.

4. Open the Makefile and ensure that the variables `DOCKER_IMAGE_NAME` and `DOCKER_CONTAINER_NAME` are appropriately set.

5. Build the Docker image and start the container by running the following command:

   ```bash
   make run


## API Endpoints

The following are the main API endpoints available:

- `POST /users`: Sign up a new user.
- `POST /users/name/:name`: Log in to an existing user account.
- `DELETE /users/:id`: Delete existing user account.
- `PUT /users/:id`: update user account.
- `POST /post`: Create a new post.
- `GET /post/{postId}`: Get a post.
- `GET /post/{userId}`: Get all posts created by user account.
- `DELETE /post/{postId}`: Delete a post.
- `PUT /post/{postId}`: Update an existing post.
- `GET /post/feeds/{userId}`: Get feed for user account.
- `POST /friend`: Add a new friend.
- `GET /friend/users/:userId`: Get friends by user account.
- `GET /friend/recommendation/:userId`: Get friend recommendations for the user.
- `POST /comment`: Add a comment to a post.
- `GET /comment/post/:id`: Get comments for a post.
- `PUT /comment/{commentId}`: Update a comment.
- `DELETE /comment/{commentId}`: Delete a comment.
- `POST /like/post/:postId/user/:userId`: Like a post.
- `DELETE /like/post/:postId/user/:userId`: Unlike a post.

For detailed API documentation and examples, refer to the API documentation file or the Swagger UI accessible at `http://localhost:8080/swagger-ui.html`.

## Contribution

Contributions to this project are welcome. Feel free to open issues and submit pull requests to suggest improvements, report bugs, or add new features.

## License

This project is licensed under the [MIT License](LICENSE).