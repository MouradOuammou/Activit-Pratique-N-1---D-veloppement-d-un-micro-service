package tp.ouammou.bankbankaccountservice.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class CustomDataFetcherExceptionResolver implements DataFetcherExceptionResolver {
    protected GraphQLError resolveToSingleError(Throwable exception, DataFetchingEnvironment environment) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return "Custom error message: " + exception.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return Collections.emptyList(); // Avoid List.of() if compatibility with Java < 9
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }


            @Override
            public List<Object> getPath() {
                return environment.getExecutionStepInfo().getPath().toList();
            }

            @Override
            public Map<String, Object> toSpecification() {
                return Map.of(
                        "message", getMessage(),
                        "errorType", getErrorType().toString()
                );
            }

            @Override
            public Map<String, Object> getExtensions() {
                return Map.of(
                        "exceptionClass", exception.getClass().getSimpleName(),
                        "details", exception.getMessage()
                );
            }
        };
    }
}
