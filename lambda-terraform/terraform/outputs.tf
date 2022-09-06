output "dynamodb-id" {
  description = "Dynamo DB id"
  value       = aws_dynamodb_table.learning-db.id
}