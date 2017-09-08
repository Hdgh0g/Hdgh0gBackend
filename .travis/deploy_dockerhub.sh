#!/bin/sh
set -ex
docker login -e $DOCKER_EMAIL -u $DOCKER_USER -p $DOCKER_PASS
if [ "$TRAVIS_BRANCH" = "master" ]; then
    TAG="latest"
else
    TAG="$TRAVIS_BRANCH"
fi
docker build -t hdgh0g/$1:$TAG .
docker push hdgh0g/$1