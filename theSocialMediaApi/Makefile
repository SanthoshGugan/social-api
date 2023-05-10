IMAGE_NAME = the-social-media-api
CONTAINER_NAME = the-social-media-api

.PHONY: run
run:
	docker build -t $(IMAGE_NAME) .
	docker stop $(CONTAINER_NAME) || true
	docker rm $(CONTAINER_NAME) || true
	docker run -d -p 8080:8080 --name $(CONTAINER_NAME) $(IMAGE_NAME)