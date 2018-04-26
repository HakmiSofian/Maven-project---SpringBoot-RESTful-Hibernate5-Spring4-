# Instructions

## SQL

In the `sql` directory, you will find a `structure.sql` file containing a base sql schema.

This is the database structure we will use for this exercice.

Your first task is to optimize this schema for performance and consistency keeping in mind that:
* A category can contain 0 to n assets
* An asset can be in 0 to n categories
* Categories can't have the same id
* Assets can't have the same id
* Assets can't have the same name
* Categories can't have the same name
* Since it's a REST API, both assets and categories will be queried using their ids.

As soon as you'll be done with those optimizations, import your schema in a local database.

You can now import some test data from the `data.sql` file.

## Java

We need you to create a java web service serving REST requests.

In the `java` directory, you'll find a sample Spring Application pre-configured with hibernate and postgresql (feel free to update the configuration if needed).

Starting it will start a server listening on local port `8080`. Check that it's working prior to start working on this part.

What we want you to implement is an endpoint listening on `GET /category` and that will return a list of all known categories, using the DTOs present in the `tv.alphanetworks.exo.dto` package. Feel free to ignore the `downloads` field for now.

Please be cautionous while implementing this endpoint and pay attention to the good practices when it comes to Spring architectures (DTOs, DAOs, services, models, controllers, ...) a default package structure is provided but feel free to change it.

## Testing

Do you know what unit tests are ? If so, write some... (Only for Java)
