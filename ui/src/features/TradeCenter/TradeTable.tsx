import {TableHeaders} from "./TableHeaders";
import {TableRows} from "./TableRows";
import {Col, Container, Row, Table} from "react-bootstrap";

export const TradeTable = (props: any) => {
    return (
        <Container>

            <Row>
                <Col>
                    <Table striped bordered hover size="sm">
                        <TableHeaders type={'buy'}/>
                        <TableRows rows={props.tradeTable.buyingOffers}/>
                    </Table>
                </Col>
                <Col>
                    <Table striped bordered hover size="sm">
                        <TableHeaders type={'sell'}/>
                        <TableRows rows={props.tradeTable.sellingOffers}/>
                    </Table>
                </Col>
            </Row>
        </Container>
    );
}
